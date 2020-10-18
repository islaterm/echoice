package ecchoice.scrapping

import khttp.post

/**
 * This class' function is to request data to e-hentai's API.
 *
 * For information on the API's usage refer to [ehwiki](https://ehwiki.org/wiki/API).
 *
 * @author [Ignacio Slater Muñoz](islaterm@gmail.com)
 * @version 1.0.1.4
 * @since 1.0
 */
class EHFetcher {
  private val apiURL = "https://api.e-hentai.org/api.php"
  private val titleKey = "title"
  private val thumbnailKey = "thumb"

  /**
   * Creates and returns a gallery for a given ``url``.
   */
  fun getGallery(url: String): EHGallery {
    val query = mapOf(
      "method" to "gdata",
      "gidlist" to listOf(parseURL(url).toList()),
      "namespace" to 1
    )
    val gMetaData =
      (post(apiURL, json = query).jsonObject.getJSONArray("gmetadata").toList())[0] as Map<*, *>
    return EHGallery(url, gMetaData[titleKey] as String, gMetaData[thumbnailKey] as String, setOf())
  }

  /**
   * Parses the given ``url`` and returns a ``Pair<Long, String>`` containing the
   * _gallery id_ and the _gallery token_ respectively.
   */
  internal fun parseURL(url: String): Pair<Long, String> {
    val rawValues = url.replace("https://e-hentai.org/g/", "").split("/")
    return Pair(rawValues[0].toLong(), rawValues[1])
  }
}

/**
 * Data class that contains the metadata of a gallery from
 * [e-hentai](https://e-hentai.org)
 */
data class EHGallery(
  val link: String,
  val title: String,
  val thumbnailURL: String,
  val tags: Set<String>
)
package ecchoice.scrapping

/**
 * This class' function is to request data to e-hentai's API.
 *
 * For information on the API's usage refer to [ehwiki](https://ehwiki.org/wiki/API).
 *
 * @author [Ignacio Slater Muñoz](islaterm@gmail.com)
 * @version 1.0.1.3
 * @since 1.0
 */
class EHFetcher {
  fun getGallery(link: String): EHGallery {
    return EHGallery(link, "", "", setOf())
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
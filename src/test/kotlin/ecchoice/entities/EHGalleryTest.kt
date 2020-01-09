package ecchoice.entities

import ecchoice.scrapping.EHFetcher
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private const val GALLERY_LINK = "https://e-hentai.org/g/618395/0439fa3666/"

/**
 * Test set for the functionalities of the ``EHGallery`` class.
 *
 * @author [Ignacio Slater Muñoz](islaterm@gmail.com)
 * @version 1.0.1.4
 * @since 1.0
 */
internal class EHGalleryTest {

  private lateinit var testFetcher: EHFetcher

  /**
   * Creates a new fetcher to request metadata from
   * [e-hentai's API](https://api.e-hentai.org/api.php)
   */
  @org.junit.jupiter.api.BeforeEach
  fun setUp() {
    testFetcher = EHFetcher()
  }

  /**
   * Retrieves the _gallery id_ and _gallery token_ from the link defined in
   * [GALLERY_LINK].
   */
  @Test
  fun parseLinkTest() {
    val idTokenPair = testFetcher.parseURL(GALLERY_LINK)
    assertEquals(Pair(618395, "0439fa3666"), idTokenPair)
  }

  /**
   * Tests that the fetcher can obtain the gallery data correctly.
   */
  @Test
  fun testGalleryFetch() {
    val testEHGallery = testFetcher.getGallery(GALLERY_LINK)
    assertEquals(GALLERY_LINK, testEHGallery.link)
    assertEquals(
      "(Kouroumu 8) [Handful☆Happiness! (Fuyuki Nanahara)] " +
          "TOUHOU GUNMANIA A2 (Touhou Project)",
      testEHGallery.title
    )
    assertEquals(
      "https://ehgt.org/14/63/" +
          "1463dfbc16847c9ebef92c46a90e21ca881b2a12-1729712-4271-6032-jpg_l.jpg",
      testEHGallery.thumbnailURL
    )
    assertEquals(
      setOf(
        "Non-H",
        "parody:touhou project",
        "group:handful happiness",
        "artist:nanahara fuyuki",
        "full color",
        "artbook"
      ), testEHGallery.tags
    )
  }

}
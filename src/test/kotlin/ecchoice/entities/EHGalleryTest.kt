package ecchoice.entities

import ecchoice.scrapping.EHFetcher
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private const val GALLERY_LINK = "https://e-hentai.org/g/618395/0439fa3666/"
private const val GALLERY_TITLE = "(Kouroumu 8) [Handful☆Happiness! (Fuyuki Nanahara)] " +
    "TOUHOU GUNMANIA A2 (Touhou Project)"
private const val GALLERY_THUMBNAIL_URL = "https://ehgt.org/14/63/" +
    "1463dfbc16847c9ebef92c46a90e21ca881b2a12-1729712-4271-6032-jpg_l.jpg"
private val GALLERY_TAGS = setOf(
  "Non-H",
  "parody:touhou project",
  "group:handful happiness",
  "artist:nanahara fuyuki",
  "full color",
  "artbook"
)

/**
 * Test set for the functionalities of the ``EHGallery`` class.
 *
 * @author [Ignacio Slater Muñoz](islaterm@gmail.com)
 * @version 1.0.1.2
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
   * Tests that the fetcher can obtain the gallery data correctly.
   */
  @Test
  fun testGalleryFetch() {
    val testEHGallery = testFetcher.getGallery(GALLERY_LINK)
    assertEquals(GALLERY_LINK, testEHGallery.galleryLink)
    assertEquals(GALLERY_TITLE, testEHGallery.title)
    assertEquals(GALLERY_THUMBNAIL_URL, testEHGallery.thumbnailURL)
    assertEquals(GALLERY_TAGS, testEHGallery.tags)
  }
}
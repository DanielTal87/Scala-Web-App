package services

import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject

class Coupon(val receivedTitle: String, val receivedPrice: Int, val receivedBarcode: String, val receivedImageURL: String, val receivedExpiryDate: String) {
  val title = receivedTitle
  val price = receivedPrice
  val imageURL = receivedImageURL
  val expiryDate = receivedExpiryDate
  val barcode = receivedBarcode

  def getObjectFromMongoDB(): DBObject = {
    MongoDBObject("title" -> title, "price" -> price, "barcode" -> barcode, "imageURL" -> imageURL, "expireDate" -> expiryDate)
  }
}

package services


import com.mongodb.casbah._

class MongoDB {

  val mongoCon = MongoConnection()("store")("coupons")

  /**
    * adds coupons to the data-base
    */
  def addCoupons(): Unit = {
    val coupone_1: Coupon = new Coupon("Baby shoes Coupon", 50, "3344F99J", "@routes.Assets.versioned(\"images/first.jpg\")", "01/08/18")
    mongoCon += coupone_1.getObjectFromMongoDB()
    val coupone_2: Coupon = new Coupon("A dairy meal for the whole family", 30, "3844FK9J", "@routes.Assets.versioned(\"images/second.jpg\")", "01/08/18")
    mongoCon += coupone_2.getObjectFromMongoDB()
    val coupone_3: Coupon = new Coupon("Vacation at the Fattal hotel in Eilat", 70, "3PK4F69J", "@routes.Assets.versioned(\"images/third.jpg\")", "01/08/18")
    mongoCon += coupone_3.getObjectFromMongoDB()
    val coupone_4: Coupon = new Coupon("1+1 On a ticket to the Luna Park", 50, "3PK9TPL6", "@routes.Assets.versioned(\"images/four.jpg\")", "01/08/18")
    mongoCon += coupone_4.getObjectFromMongoDB()
    val coupone_5: Coupon = new Coupon("The new Havaianas collection for summer", 40, "3PK4F69W", "@routes.Assets.versioned(\"images/five.jpg\")", "01/08/18")
    mongoCon += coupone_5.getObjectFromMongoDB()
  }

  /**
    * The function gets all the coupons from the data-base into the couponsMatrix
    * @return the coupons matrix
    */
  def findAllCoupons: Array[Array[String]] = {
    val cursor = mongoCon.find()
    val couponsMatrix: Array[Array[String]] = Array.ofDim[String](5, 5)
    var index: Int = 0
    while (cursor.hasNext) {
      val document = cursor.next()
      couponsMatrix(index)(0) = document.get("title").toString
      couponsMatrix(index)(1) = document.get("price").toString
      couponsMatrix(index)(2) = document.get("barcode").toString
      couponsMatrix(index)(3) = document.get("imageURL").toString
      couponsMatrix(index)(4) = document.get("expireDate").toString
      index = index + 1
    }
    couponsMatrix
  }

  /**
    * @return true if data-base is empty, false otherwise
    */
  def isDBEmpty: Boolean = {
    mongoCon.isEmpty
  }
}

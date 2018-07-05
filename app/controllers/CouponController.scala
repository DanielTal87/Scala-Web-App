package controllers

import javax.inject._
import play.api.mvc._
import services.MongoDB

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class CouponController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
    * Create an Action to render an HTML page with The coupons website.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def show = Action { implicit request =>
    val mongo = new MongoDB()
    if (mongo.isDBEmpty) {sdasd
      mongo.addCoupons()
    }
    val couponsMatrix: Array[Array[String]] = mongo.findAllCoupons
    Ok(views.html.allCoupons(couponsMatrix))
  }


}

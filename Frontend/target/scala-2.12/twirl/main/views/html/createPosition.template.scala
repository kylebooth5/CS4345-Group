
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object createPosition extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(authorizeMessage: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Create Position</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

            <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="docs/images/favicon.ico" />
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css" integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ==" crossorigin=""/>
        <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js" integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og==" crossorigin=""></script>
    </head>
    <body>
        <div class="row">
            <div class="col s12 m6">
        <header class="topbar">
            <h1 class="focused" style="font-size: 37px;
                color: #57a957">
                <strong>Create Position</strong>
            </h1>
        </header>
            </div>
        </div>


        <div class="row">
            <div class="card col s4 offset-s4 ">
                <div class="card-panel">
                    <form action=""""),_display_(/*34.36*/routes/*34.42*/.PositionController.positionHandler()),format.raw/*34.79*/("""" method="GET">

                        <!--create a select statement-->
                        <div class="row">
                        <div class="input-field col s12">
                            <select style = "display: block;" id="course" name="course">
                                <option value="" disabled selected>Select a Course</option>
                                <option value="CS 4345">CS 4345</option>
                                <option value="CS 5382">CS 5382</option>
                                <option value="CS 5320">CS 5320</option>
                            </select>
                        </div>
                            <div class="row">
                            <div class="input-field col s12">
                                <select style = "display: block;" id="preference" name="preference">
                                    <option value="" disabled selected>TA Preference</option>
                                    <option value="Under Graduate">Under Graduate</option>
                                    <option value="Graduate">Graduate</option>
                                    <option value="Both">Both</option>
                                </select>
                            </div>
                        <div class="row">
                            <div class="input-field col s12">

                                <input id="numPositions" name="numPositions" type="text" class="validate">
                                <label for="numPositions">Number of TAs Needed</label>
                            </div>
                        </div>

                        """),_display_(/*63.26*/if(authorizeMessage!= null)/*63.53*/{_display_(Seq[Any](format.raw/*63.54*/("""
                            """),format.raw/*64.29*/("""<div class="alert alert-primary" role="alert">
                            """),_display_(/*65.30*/authorizeMessage),format.raw/*65.46*/("""
                            """),format.raw/*66.29*/("""</div>
                            <br>
                        """)))}),format.raw/*68.26*/("""

                        """),format.raw/*70.25*/("""<div class="row">
                            <button id="api-search-button" class="btn col s4 offset-s4" type="submit">Create</button>
                        </div>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
"""))
      }
    }
  }

  def render(authorizeMessage:String): play.twirl.api.HtmlFormat.Appendable = apply(authorizeMessage)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (authorizeMessage) => apply(authorizeMessage)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2022-10-18T20:25:24.801
                  SOURCE: /Users/katebouis/Desktop/cs/cs4345/CS4345-Group-3/Frontend/app/views/createPosition.scala.html
                  HASH: 25c83c690a1363bd95c7d88aef755510d685c899
                  MATRIX: 957->1|1077->28|2761->1687|2776->1693|2834->1730|4516->3385|4552->3412|4591->3413|4648->3442|4751->3518|4788->3534|4845->3563|4941->3628|4995->3654
                  LINES: 28->1|33->2|65->34|65->34|65->34|94->63|94->63|94->63|95->64|96->65|96->65|97->66|99->68|101->70
                  -- GENERATED --
              */
          
package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("https://cherere.com") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers

  val scn = scenario("Scenario Name")
    .repeat(1000) {
      exec(http("request_1")
        .get("/"))
    }

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}

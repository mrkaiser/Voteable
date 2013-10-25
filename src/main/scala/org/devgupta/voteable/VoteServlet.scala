package org.devgupta.voteable

import org.scalatra._
import scalate.ScalateSupport
import scala.collection.mutable
// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._


class VoteServlet extends VoteStack with JacksonJsonSupport{

  //some hacked up models
  case class Voteable(id:String,var votes:Int)
  case class Vote(voteOn:String)
  implicit def orderedVoteable(v : Voteable): Ordered[Voteable] = new Ordered[Voteable]{
    def compare(other: Voteable) = v.votes.compare(other.votes)
  }
  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit val jsonFormats: Formats = DefaultFormats


  var queue = new mutable.PriorityQueue[Voteable]()
  //before controller
  before() {
    contentType = formats("json")
  }
  get("/vote/:id") {
    //"Voted on"+{params("id")}

    queue.find(x => x.id.compare(params("id")) == 0 ) match {
      case Some(vote:Voteable) => vote.votes += 1
      case None => queue.enqueue(Voteable(params("id"),1))
    }

    //HOPEFULLY THE GARBAGE Collector loves me (GUESS WHAT IT DOESN'T)
    queue = queue.clone()
    queue.toList
  }

  post("/vote") {
    println("Got to Vote!")
    val vote = parsedBody.extract[Vote]
    queue.find(x => x.id.compare(vote.voteOn) == 0 ) match {
      case Some(vote:Voteable) => vote.votes += 1
      case None => queue.enqueue(Voteable(vote.voteOn,1))
    }

    //HOPEFULLY THE GARBAGE Collector loves me (GUESS WHAT IT DOESN'T)
    queue = queue.clone()
  }

  get("/top") {
    if(queue.size != 0) queue.dequeue else None
  }
  
}

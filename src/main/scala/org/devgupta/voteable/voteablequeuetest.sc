import org.devgupta.voteable.VoteServlet
import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: mrkaiser
 * Date: 10/8/13
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
object ScalaWorksheet {
  case class Voteable(id:String,var votes:Int)
  implicit def orderedVoteable(v : Voteable): Ordered[Voteable] = new Ordered[Voteable]{
    def compare(other: Voteable) = v.id.compare(other.id)
  }


  val queue = new mutable.PriorityQueue[Voteable]()
  queue.enqueue(new Voteable("a",1),new Voteable("b",2))
  println(queue)
  queue.find(x => x.id.compare("a") == 0 ) match {
    case Some(vote:Voteable) => vote.votes += 1
    case None => "Uh Oh"
  }
  queue.find(x => x.id.compare("a") == 0 ) match {
    case Some(vote:Voteable) => vote.votes += 1
    case None => "Uh Oh"
  }
  println(queue)

  queue.clone()



}



package com.knoldus.akka

import akka.actor.{Actor, ActorSystem, Props}

case class Greet(name: String)

class Greeter extends Actor {
  override def receive: Receive = {
    case Greet(name) => println(s"Hello $name")
    case _ => println("Not defined.")
  }
}

object HelloWorld extends App{

  private val system = ActorSystem("akka")

  private val greeter = system.actorOf(Props[Greeter], "greeter")

  greeter ! Greet("Jitendra")
}

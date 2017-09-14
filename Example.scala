import com.twitter.function.JavaConsumer

object Example {
    val jc = new JavaConsumer[String] {
        def apply(a: String): Unit = println("Hello world: " + a)
    }

    def main(args: Array[String]): Unit = {
         jc(args.mkString(", "))
     }
 }

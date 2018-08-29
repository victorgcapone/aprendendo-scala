package gipsy

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class GipsyApplication

// Para extends App funcionar com o Spring usar scala-sdk 2.10.4
object GipsyApplication extends App{
  SpringApplication.run(classOf[GipsyApplication])
}

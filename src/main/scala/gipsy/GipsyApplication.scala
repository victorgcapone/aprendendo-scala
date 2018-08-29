package gipsy

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class GipsyApplication

object GipsyApplication extends App{
  SpringApplication.run(classOf[GipsyApplication])
}

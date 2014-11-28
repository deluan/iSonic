import com.deluan.isonic.HelloController
import spock.lang.Specification

class SimpleSpec extends Specification {

    def "should return a greeting"() {
        expect:
          new HelloController().index() == 'Greetings from iSonic!'
    }
}

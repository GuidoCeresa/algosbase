package algosbase



import org.junit.*
import grails.test.mixin.*

@TestFor(ProvaController)
@Mock(Prova)
class ProvaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/prova/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.provaInstanceList.size() == 0
        assert model.provaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.provaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.provaInstance != null
        assert view == '/prova/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/prova/show/1'
        assert controller.flash.message != null
        assert Prova.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/prova/list'

        populateValidParams(params)
        def prova = new Prova(params)

        assert prova.save() != null

        params.id = prova.id

        def model = controller.show()

        assert model.provaInstance == prova
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/prova/list'

        populateValidParams(params)
        def prova = new Prova(params)

        assert prova.save() != null

        params.id = prova.id

        def model = controller.edit()

        assert model.provaInstance == prova
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/prova/list'

        response.reset()

        populateValidParams(params)
        def prova = new Prova(params)

        assert prova.save() != null

        // test invalid parameters in update
        params.id = prova.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/prova/edit"
        assert model.provaInstance != null

        prova.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/prova/show/$prova.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        prova.clearErrors()

        populateValidParams(params)
        params.id = prova.id
        params.version = -1
        controller.update()

        assert view == "/prova/edit"
        assert model.provaInstance != null
        assert model.provaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/prova/list'

        response.reset()

        populateValidParams(params)
        def prova = new Prova(params)

        assert prova.save() != null
        assert Prova.count() == 1

        params.id = prova.id

        controller.delete()

        assert Prova.count() == 0
        assert Prova.get(prova.id) == null
        assert response.redirectedUrl == '/prova/list'
    }
}

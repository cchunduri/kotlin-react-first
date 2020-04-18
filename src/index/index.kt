package index

import app.*
import components.searchComp
import kotlinext.js.*
import react.dom.*
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import kotlin.browser.*

fun main(args: Array<String>) {
    requireAll(require.context("src", true, js("/\\.css$/")))

    render(document.getElementById("root")) {
        browserRouter {
            switch {
                route("/", exact = true) {
                    app()
                }

                route("/search") {
                    searchComp()
                }
            }
        }
    }
}

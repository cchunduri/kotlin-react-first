package components

import api.PlaceResponse
import api.getCountryData
import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.input
import react.dom.span
import styled.css
import styled.styledDiv
import styled.styledInput

interface SearchState: RState {
    var searchResponse: PlaceResponse
    var inputText: String
}
class SerachComp:RComponent<RProps, SearchState>() {
    override fun RBuilder.render() {
        appHeader()
        styledInput {
            css {
                margin (all = 10.px)
            }
            attrs {
                type = InputType.text
                placeholder = "Enter the country name"
                onChangeFunction = { event ->
                    handleOnChange(event)
                }
            }
        }

        if (state.searchResponse != null){
            styledDiv {
                css {
                    margin(all = 10.px)
                    padding(all = 5.px)
                    display = Display.flex
                    flexDirection = FlexDirection.column
                }
                span {
                    + "Result:"
                }
                span {
                    +"Name: ${state.searchResponse.nameOfThePlace}"
                }
                span {
                    +"Deaths: ${state.searchResponse.numberOfDeaths}"
                }
                span {
                    +"Confirmed: ${state.searchResponse.numberOfConfirmed}"
                }
                span {
                    +"Recovered: ${state.searchResponse.numberOfRecovered}"
                }
            }
        }
    }

    private fun handleOnChange(event: Event) {
        val target = event.target as HTMLInputElement
        if (target.value.length >=2) {
            getCountryData(target.value)
                    .then { response ->
                        setState {
                            state.searchResponse = response.data
                        }
                    }
        }
    }
}

fun RBuilder.searchComp() = child(SerachComp::class) {

}
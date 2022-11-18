import QtQuick 2.12
import QtQuick.Window 2.12
import QtQuick.Layouts 1.3
import QtQuick.Controls 2.5

ApplicationWindow {
    visible: true
    title: qsTr("Hello...")
    minimumWidth: 600

ScrollView {
    anchors.fill: parent
    padding: 10

    GridLayout {
        rowSpacing: 10
        columns: 2

        Label {
            id: nombre_etiqueta
            text: qsTr("Teclear aqui un nombre:")
        }

        TextField {
            id: nombre
            focus: true
        }

        Button {
            text: qsTr("Clic aqui para saludar")
            onClicked: {
                saludo.text = qsTr("Hello, ") + nombre.text + qsTr(".")
            }
        }

        TextField {
            id: saludo
            enabled: false
            background: Rectangle { color: "#fff6e6"}
            Layout.minimumWidth: 300
        }

    }
}
}

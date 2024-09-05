package com.slade.fxtutorial

import javafx.application.Application
import javafx.application.ConditionalFeature
import javafx.application.Platform
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Cursor
import javafx.scene.Group
import javafx.scene.PerspectiveCamera
import javafx.scene.Scene
import javafx.scene.chart.AreaChart
import javafx.scene.chart.BarChart
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.PieChart
import javafx.scene.chart.ScatterChart
import javafx.scene.chart.StackedBarChart
import javafx.scene.chart.XYChart
import javafx.scene.control.*
import javafx.scene.control.cell.MapValueFactory
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.shape.Box
import javafx.scene.shape.CullFace
import javafx.scene.transform.Rotate
import javafx.scene.web.WebView
import javafx.stage.FileChooser
import javafx.stage.Stage
import java.io.File
import java.io.FileInputStream
import java.net.URL
import kotlin.math.absoluteValue

data class Person(
    val firstName: String,
    val lastName: String,
)

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val vBox = fxmlLoader.load<VBox>()

//        val brands = ListView<String>().apply {
//            items += "Hewlett Packard"
//            items += "Lenovo"
//            items += "Dell"
//            items += "Asus"
//            items += "Acer"
//
//            selectionModel.selectionMode = SelectionMode.MULTIPLE
//        }

//        val imageView = ImageView("file:///home/slade/clion-2024.2.0.1/bin/clion.png")

        val sliderLabel = TextField("54.6")
        val  slider = Slider(0.0, 100.0, sliderLabel.text.toDoubleOrNull()?.let { it % 101}  ?: 0.0).apply {
            isShowTickMarks = true
            isShowTickLabels = true
            majorTickUnit = 10.0
            minorTickCount = 5
        }

        val webView = WebView()
//        val pieChart = PieChart().apply {
//            data.addAll(
//                PieChart.Data("Desktop", 213.0),
//                PieChart.Data("Phone", 67.0),
//                PieChart.Data("Tablet", 36.0),
//            )
//        }
        val subjects = listOf("mathematics", "english", "agriculture", "chemistry", "physics", "geography")

//        val table = TableView<Map<String, Int>>().apply {
//            columns.addAll(
//                subjects.map { subject -> TableColumn<Map<String, Int>, String>(subject.replaceFirstChar { char -> char.uppercase() }).apply {
//                    cellValueFactory = PropertyValueFactory(subject)
//                } }
//            )
//
//            repeat(20) {
//                items.add(mapOf(*subjects.map { subject ->
//                    subject to (50..99).random()
//                }.toTypedArray()))
//            }
//        }

//        val table = TableView<Person>().apply {
//            columns.addAll(
//                TableColumn<Person, String>("First Name").apply {
//                    cellValueFactory = PropertyValueFactory("lastName")
//                },
//                TableColumn<Person, String>("Last Name").apply {
//                    cellValueFactory = PropertyValueFactory("firstName")
//                },
//            )
//
//            items.addAll(
//                Person("John", "Doe"),
//                Person("Jane", "Deer"),
//            )
//        }

//        val treeView = TreeView(
//            TreeItem("Tutorials").apply {
//                children.addAll(
//                    TreeItem("Web Tutorials").apply {
//                        children.addAll(
//                            TreeItem("HTML Tutorial"),
//                            TreeItem("HTML5 Tutorial"),
//                            TreeItem("CSS Tutorial"),
//                            TreeItem("SASS Tutorial"),
//                            TreeItem("SVG Tutorial"),
//                        )
//                    },
//                    TreeItem("Java Tutorials").apply {
//                        children.addAll(
//                            TreeItem("Basics"),
//                            TreeItem("Collections"),
//                            TreeItem("Concurrency"),
//                            TreeItem("Networking")
//                        )
//                    }
//                )
//            }
//        )

//        val barChart = BarChart(
//            CategoryAxis().apply {
//                label = "Devices"
//            },
//            NumberAxis().apply {
//                label = "Visits"
//            }
//        ).apply {
//            title = "Site visits from 2014 to 2016"
//            data.addAll(
//                listOf(
//                    2014 to listOf(178, 65, 23),
//                    2015 to listOf(567, 75, 56),
//                    2016 to listOf(300, 123, 99)
//                ).map { (year, visits) ->
//                    XYChart.Series<String, Number>().apply {
//                        name = "$year"
//                        data.addAll(
//                            XYChart.Data("Desktop", visits[0]),
//                            XYChart.Data("Phone", visits[1]),
//                            XYChart.Data("Tablet", visits[2])
//                        )
//                    }
//                }
//            )
//        }

//        val stackedBarChart = StackedBarChart(
//            CategoryAxis().apply {
//                label = "Devices"
//                categories.addAll("Desktop", "Phone", "Tablet")
//            },
//            NumberAxis().apply {
//                label = "Visits"
//            }
//        ).apply {
//            title = "Site visits from 2014 to 2016"
//            data.addAll(
//                listOf(
//                    "Desktop" to listOf(500, 65, 20),
//                    "Phone" to listOf(500, 75, 20),
//                    "Tablet" to listOf(500, 123, 20)
//                ).map { (device, visits) ->
//                    XYChart.Series<String, Number>().apply {
//                        name = device
//                        data.addAll(
//                            XYChart.Data("2014", visits[0]),
//                            XYChart.Data("2015", visits[1]),
//                            XYChart.Data("2016", visits[2])
//                        )
//                    }
//                }
//            )
//        }

//        val scatterChart = ScatterChart(
//            NumberAxis().apply {
//                label = "Number of employees"
//            },
//            NumberAxis().apply {
//                label = "Revenue per employee"
//            }
//        ).apply {
//            data.addAll(
//                listOf("HP", "Lenovo", "Dell").map { brand ->
//                    XYChart.Series<Number, Number>().apply {
//                        name = brand
//                        data.addAll(
//                            (1..10).map {
//                                XYChart.Data((34..123).random(), (34..123).random())
//                            }
//                        )
//                    }
//                }
//            )
//        }

//        val areaChart = AreaChart(
//            NumberAxis().apply {
//                label = "Number of employees"
//            },
//            NumberAxis().apply {
//                label = "Revenue per employee"
//            }
//        ).apply {
//            data.addAll(
//                listOf("HP", "Lenovo", "Dell").map { brand ->
//                    XYChart.Series<Number, Number>().apply {
//                        name = brand
//                        data.addAll(
//                            (0..10).map { x ->
//                                XYChart.Data(x, (34..123).random())
//                            }
//                        )
//                    }
//                }
//            )
//        }

//        if(Platform.isSupported(ConditionalFeature.SCENE3D)) {
//            println("Sorry, 3D is not supported in JAVAFX running on this platform.")
//            return
//        }

//        val box3D = Box(100.0, 100.0, 100.0)
//        box3D.cullFace = CullFace.NONE
//        box3D.translateX = 250.0
//        box3D.translateY = 100.0
//        box3D.translateZ = 400.0
//
//        val camera = PerspectiveCamera(false)
//        camera.translateX = 150.0
//        camera.translateY = -100.0
//        camera.translateZ = 250.0
//
//        val root = Group(box3D)
//        root.rotationAxis = Rotate.X_AXIS
//        root.rotate = 30.0

        val androidHome = System.getenv("JAVA_HOME") ?: System.getProperty("user.home") ?: "Not Found"

        val fileChooser = FileChooser().apply {
            initialDirectory = File("/home/slade/Desktop")
            extensionFilters.addAll(
                FileChooser.ExtensionFilter("*.txt", "*.json")
            )
        }

//        vBox.apply {
//            background = Background(
//                BackgroundImage(
//                    Image(FileInputStream("/home/slade/Downloads/wallpaperflare.com_wallpaper (1).jpg")),
//                    BackgroundRepeat.NO_REPEAT,
//                    BackgroundRepeat.NO_REPEAT,
//                    BackgroundPosition.CENTER,
//                    BackgroundSize(
//                        100.0,
//                        100.0,
//                        true,
//                        true,
//                        true,
//                        true
//                    )
//                )
//            )
//        }

        val colorGroup = ToggleGroup()

        val gridPane = GridPane().apply {
            hgap = 5.0
            vgap = 5.0
            padding = Insets(5.0)
            background = Background(BackgroundFill(Color.BLACK, null, null))
            listOf(listOf("1", "2", "3"), listOf("4", "5", "6"), listOf("7", "8", "9"), listOf("*", "0", "#")).forEachIndexed { row, s ->
                s.forEachIndexed { col, lbl ->
                    add(
                        Button(lbl).apply {
                            prefWidth = 150.0
                            textFill = Color.WHITE
                            background = Background(BackgroundFill(Color.DARKGREEN, CornerRadii(3.0), null))
                        },
                        col,
                        row,
                        1,
                        1
                    )
                }
            }
        }

        vBox.children.addAll(
//            MenuBar().apply {
//                menus.addAll(
//                    Menu("Menu 1").apply {
//                        items.add(Menu("Menu 1.1").apply {
//                            items.addAll(
//                                MenuItem("Item 1.1.1"),
//                                CheckMenuItem("Check this!")
//                            )
//                        })
//
//                        items.addAll(
//                            CustomMenuItem().apply {
//                                content = Slider(0.0, 100.0, 50.0).apply {
//                                    onAction = EventHandler {
//                                        gridPane.background = Background(BackgroundFill(Color.color(0.0,0.0,0.0,value/100.0 ), null, null))
//                                    }
//                                }
//                                isHideOnClick = false
//                            },
//                            SeparatorMenuItem(),
//                            RadioMenuItem("Red").apply { colorGroup.toggles.add(this) },
//                            RadioMenuItem("Green").apply { colorGroup.toggles.add(this) },
//                            RadioMenuItem("Blue").apply { colorGroup.toggles.add(this) },
//                            SeparatorMenuItem(),
//                            *listOf(
//                                MenuItem("Item 1"),
//                                MenuItem("Item 2"),
//                                MenuItem("Item 3"),
//                            ).map { menuItem -> menuItem.apply { onAction = EventHandler { stage.title = menuItem.text } } }
//                                .toTypedArray()
//                        )
//                    }
//                )
//            },
//            gridPane,
//            TextArea().apply {
//                contextMenu = ContextMenu().apply {
//                    items.addAll(
//                        MenuItem("Choice 1"),
//                        MenuItem("Choice 2"),
//                        MenuItem("Choice 3")
//                    )
//                }
//            }
//            FlowPane().apply {
//                hgap = 5.0
//                vgap = 5.0
////                rowValignment = VPos.BOTTOM
//                orientation = Orientation.VERTICAL
//                children.addAll(
//                    (1..20).map { (40..100).random() }.map { randomInteger ->
//                        Button().apply {
//                            background = Background(BackgroundFill(Color.DARKGREEN, CornerRadii(5.0), Insets.EMPTY))
//                            prefWidth = 60.0
//                            prefHeight = randomInteger.toDouble()
//                        }
//                    }
//                )
//            }
//            Button("Media Labs").apply {
//                textFill = Color.WHITE
//                background = Background(BackgroundFill(Color.DARKGRAY, CornerRadii(10.0), null))
//            }
//            ScrollPane().apply {
//                content = ImageView(Image(FileInputStream("/home/slade/Downloads/wallpaperflare.com_wallpaper (1).jpg")))
//                isPannable = true
//                isFitToWidth = true
//                hbarPolicy = ScrollPane.ScrollBarPolicy.NEVER
//            }
//            TabPane().apply {
//                tabs.addAll(
//                    Tab("Planes", Label("Show all planes")),
//                    Tab("Cars", Label("Show all cars")),
//                    Tab("Boats", Label("Show all Boats"))
//                )
//            },
//            Accordion().apply {
//                panes.addAll(
//                    TitledPane("Boats", Label("Show all available boats")),
//                    TitledPane("Cars", Label("Show all available cars")),
//                    TitledPane("Planes", Label("Show all available planes"))
//                )
//            }
//            Button("Choose File").apply {
//                onAction = EventHandler {
//                    fileChooser.showOpenDialog(stage)
//                }
//            },
//            ProgressBar(0.5),
//            TextField().apply {
//                tooltip = Tooltip("Enter your email address").apply {
//                    graphic = ImageView(Image("http://localhost:3000/images/cloud_hosting.svg"))
//                }
//            },
//            PasswordField(),
//            VBox(sliderLabel, slider),
//            TextArea().apply {
//                prefRowCount = 6
//
//            }
//            ComboBox<String>().apply {
//            items += "C++"
//            items += "Java"
//            items += "Python"
//            items += "Kotlin"
//
//            isEditable = true
//
//            onAction = EventHandler {
//                fxmlLoader.getController<HelloController>().welcomeText.text = selectionModel.selectedItem
//            }
//        },
//            brands,
//            Button("Show Selected Brands").apply {
//                onAction = EventHandler {
//                    fxmlLoader.getController<HelloController>().welcomeText.text = brands.selectionModel.selectedItems.joinToString("; ")
//                }
//            },
//            DatePicker(),
//            ColorPicker().apply {
//                onAction = EventHandler {
//                    vBox.style = "-fx-background-color: #${value.toString().substring(2)}"
//                }
//            }
        )
        // val hBox = HBox(ImageView(Image(FileInputStream("assets/images/ubuntu.png"))))
        val scene = Scene(
            gridPane,
            500.0,
            500.0
        )
//        scene.camera = camera
        scene.cursor = Cursor.OPEN_HAND
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}
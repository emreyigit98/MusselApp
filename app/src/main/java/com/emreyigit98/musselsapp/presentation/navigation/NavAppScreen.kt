package com.emreyigit98.musselsapp.presentation.navigation


import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.emreyigit98.musselsapp.R
import com.emreyigit98.musselsapp.presentation.component.SpecialDrawerMenu
import com.emreyigit98.musselsapp.presentation.component.SpecialTopAppBar
import com.emreyigit98.musselsapp.presentation.screen.customer_screen.CustomerScreenViewModel
import com.emreyigit98.musselsapp.presentation.screen.customer_screen.MainCustomerScreen
import com.emreyigit98.musselsapp.presentation.screen.mussel_screen.MainMusselScreen
import com.emreyigit98.musselsapp.presentation.screen.mussel_screen.MusselScreenViewModel
import com.emreyigit98.musselsapp.presentation.screen.open_screen.OpenScreen
import com.emreyigit98.musselsapp.presentation.screen.order_screen.OrderScreen
import com.emreyigit98.musselsapp.presentation.screen.quantity_screen.QuantityScreen
import com.emreyigit98.musselsapp.presentation.screen.query_screen.QueryScreen
import com.emreyigit98.musselsapp.presentation.screen.query_screen.QueryScreenViewModel
import com.emreyigit98.musselsapp.presentation.screen.result_screen.ResultScreen
import com.emreyigit98.musselsapp.presentation.screen.result_screen.ResultScreenViewModel
import com.emreyigit98.musselsapp.util.ScreenList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate

@Composable
fun NavAppScreen(
    scope: CoroutineScope = rememberCoroutineScope(),
    navHostController: NavHostController = rememberNavController(),
    resultScreenViewModel: ResultScreenViewModel = viewModel(),
    musselScreenViewModel: MusselScreenViewModel = hiltViewModel(),
    customerScreenViewModel: CustomerScreenViewModel = hiltViewModel(),
    queryScreenViewModel: QueryScreenViewModel = hiltViewModel(),
    localDate: LocalDate = LocalDate.now()
) {

    val resultScreenState by resultScreenViewModel.resultScreenState.collectAsState().apply {
        this.value.musselResultPrice = this.value.musselPrice * this.value.musselQuantity
    }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState, drawerContent = {
            SpecialDrawerMenu(screenList = ScreenList.screenList, nextScreen = { screen ->
                navHostController.navigate(screen.name)
            }, click = {
                scope.launch {
                    drawerState.close()
                }
            })
        }, scrimColor = Color.Transparent
    ) {
        Scaffold(topBar = {
            Surface(
                color = Color.LightGray
            ) {
                SpecialTopAppBar(topBarName = stringResource(id = R.string.top_app_bar_name),
                    onClick = {
                        scope.launch { drawerState.open() }
                    })
            }
        }) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(color = Color.White)
            ) {
                NavHost(
                    navController = navHostController, startDestination = Screen.OPEN_SCREEN.name
                ) {
                    composable(Screen.OPEN_SCREEN.name, enterTransition = {
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(100)
                        )
                    }, exitTransition = {
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(100)
                        )
                    }) {
                        OpenScreen(nextScreen = {
                            navHostController.navigate(Screen.CUSTOMER_SCREEN.name)
                            customerScreenViewModel.allCustomersName()
                        })
                    }
                    composable(Screen.CUSTOMER_SCREEN.name, enterTransition = {
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(100)
                        )
                    }, exitTransition = {
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(100)
                        )
                    }) {
                        MainCustomerScreen(customerScreenUiState = customerScreenViewModel.customerScreenUiState,
                            customerScreenViewModel = customerScreenViewModel,
                            onSelected = { item ->
                                resultScreenViewModel.addCustomerName(item)
                            },
                            onRefresh = {
                                customerScreenViewModel.refresh()
                                customerScreenViewModel.allCustomersName()
                            },
                            onNextScreen = {
                                navHostController.navigate(Screen.MUSSEL_SCREEN.name)
                                musselScreenViewModel.allMussels()
                            })
                    }
                    composable(Screen.MUSSEL_SCREEN.name, enterTransition = {
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(100)
                        )
                    }, exitTransition = {
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(100)
                        )
                    }) {
                        MainMusselScreen(musselScreenUiState = musselScreenViewModel.musselScreenUiState,
                            musselScreenViewModel = musselScreenViewModel,
                            onSelectedItem = { price, name ->
                                resultScreenViewModel.addMusselPrice(price)
                                resultScreenViewModel.addMusselName(name)
                            },
                            onRefresh = {
                                musselScreenViewModel.refresh()
                                musselScreenViewModel.allMussels()
                            },
                            onNextScreen = {
                                navHostController.navigate(Screen.QUANTITY_SCREEN.name)
                            })
                    }
                    composable(Screen.QUANTITY_SCREEN.name, enterTransition = {
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(100)
                        )
                    }, exitTransition = {
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(100)
                        )
                    }) {
                        var state by remember { mutableStateOf("") }
                        QuantityScreen(onClick = {
                            navHostController.navigate(Screen.RESULT_SCREEN.name)
                            resultScreenViewModel.addDate(date = localDate.toString())
                        }, value = state, onValueChange = { item ->
                            state = item
                            resultScreenViewModel.addMusselQuantity(item.toInt())
                        })
                    }
                    composable(Screen.RESULT_SCREEN.name, enterTransition = {
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(100)
                        )
                    }, exitTransition = {
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(100)
                        )
                    }) {
                        ResultScreen(resultScreenState = resultScreenState,
                            localDate = resultScreenState.date,
                            onClick = {
                                queryScreenViewModel.addMusselDetail(
                                    resultScreenViewModel.getMusselDetail()
                                )
                                navHostController.navigate(Screen.OPEN_SCREEN.name)
                                queryScreenViewModel.allMusselDetailList()
                            })
                    }
                    composable(Screen.QUERY_SCREEN.name, enterTransition = {
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(100)
                        )
                    }, exitTransition = {
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(100)
                        )
                    }) {
                        QueryScreen(queryScreenViewModel = queryScreenViewModel,
                            detailId = { item ->
                                navHostController.navigate("${Screen.ORDER_SCREEN.name}/${item}")
                            })
                    }
                    composable("${Screen.ORDER_SCREEN.name}/{${Screen.ORDER_SCREEN.screenName}}",
                        arguments = listOf(navArgument(Screen.ORDER_SCREEN.screenName) {
                            type = NavType.IntType
                        }),
                        enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(100)
                            )
                        },
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                animationSpec = tween(100)
                            )
                        }) {
                        val id =
                            requireNotNull(it.arguments?.getInt(Screen.ORDER_SCREEN.screenName)) { "Null" }
                        OrderScreen(
                            queryScreenViewModel = queryScreenViewModel, id = id
                        )
                    }
                }
            }
        }
    }
}
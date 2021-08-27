package com.example.ruap.di
//
//import com.example.ruap.data.Repository
//import com.example.ruap.network.AuthInterceptor
//import com.example.ruap.network.AzureApi
//import com.example.ruap.network.NewsApi
//import com.example.ruap.ui.ArticlesViewModel
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.dsl.module
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//
//val appModules = module {
//    single<Repository> { Repository(newsApi = get(),azureApi = get()) }
//}
//
//val viewModelModules = module{
//    viewModel<ArticlesViewModel> { ArticlesViewModel() }
//}
//
//val networkModule = module {
//    factory { AuthInterceptor() }
//    factory { provideOkHttpClient(authInterceptor = get(), loggingInterceptor = get()) }
//    single { provideRetrofitForNewsApi(okHttpClient = get()) }
//    single { provideNetworkForNewsApi(retrofit = get()) }
//    single { provideRetrofitForAzureApi(okHttpClient = get()) }
//    single { provideNetworkForAzureApi(retrofit = get()) }
//    single { provideLoggingInterceptor() }
//}
//
//
//fun provideRetrofitForNewsApi(okHttpClient: OkHttpClient): Retrofit {
//    return Retrofit.Builder().baseUrl("https://newsapi.org/v2/").client(okHttpClient)
//        .addConverterFactory(GsonConverterFactory.create()).build()
//}
//
//fun provideRetrofitForAzureApi(okHttpClient: OkHttpClient): Retrofit {
//    return Retrofit.Builder().baseUrl("https://ussouthcentral.services.azureml.net/workspaces/411a1d5afdf84c42b01dea227d375de6/services/3ffd82a72bae4401957c0e62aba15eb3/execute?api-version=2.0&details=true/").client(okHttpClient)
//        .addConverterFactory(GsonConverterFactory.create()).build()
//}
//
//fun provideOkHttpClient(authInterceptor: AuthInterceptor, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
//    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).addInterceptor(loggingInterceptor).build()
//}
//
//fun provideNetworkForNewsApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)
//
//fun provideNetworkForAzureApi(retrofit: Retrofit): AzureApi = retrofit.create(AzureApi::class.java)
//
//fun provideLoggingInterceptor(): HttpLoggingInterceptor {
//    val logger = HttpLoggingInterceptor()
//    logger.level = HttpLoggingInterceptor.Level.BODY
//    return logger
//}
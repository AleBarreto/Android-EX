# Android-EX
 Projeto desenvolvido com o intuito de ajudar na criação/setup de novos projetos Android modularizado, diminuindo consideravelmente o tempo de configuração do gradle e buildSrc.
 
 obs: Cada modulo segue o conceito do clean arch baseado na divisão de camadas [data, domain, presentation, ...], porém todo o projeto foi modularizado pensando em novas features e cada feature possue suas camadas.
 
 ## Principais Tecnologias/Frameworks
- Flow
- Hilt
- ViewBinding
- Gradle Kts
- AndroidX
- MockK
- Koin (Toda configuração está em uma branch especifica, criada por [@jotavier](https://github.com/jotavier) )

## Navegação entre modulos


o modulo de navigation foi criado para conter todos os contratos de navegação entre os modulos, exemplo:

```kotlin
// :navigation file: FeatureBNavigation.kt
interface FeatureBNavigation {
    fun navigationToFeatureB(context: Context, idMovie: Long)
}
```
e cada modulo deve prover a implementação do contrato e fornecer na arvore de dependencia, assim ensinando como ser chamado.

```kotlin
// :featureB file: FeatureBNavigationImpl.kt
const val EXTRA_ID_MOVIE = "id_movie"
internal class FeatureBNavigationImpl @Inject constructor() : FeatureBNavigation {
    override fun navigationToFeatureB(context: Context, idMovie: Long) {
        val intent = Intent(context, FeatureBActivity::class.java)
        intent.putExtra(EXTRA_ID_MOVIE, idMovie)
        context.startActivity(intent)
    }
}
```

fornecendo para injeção de dependencia com Hilt

```kotlin
// :featureB file: NavigationModule.kt
@Module
@InstallIn(SingletonComponent::class)
internal abstract class NavigationModule {
    @Binds
    abstract fun bindNavigation(
        featureBNavigationImpl: FeatureBNavigationImpl
    ): FeatureBNavigation
}
```

como chamar a activity do moduloB no moduloA:

```kotlin
// :featureA file: FeatureAActivity.kt
@Inject
lateinit var navigation: FeatureBNavigation

navigation.navigationToFeatureB(this, idMovie = id)
```

![navigation](https://github.com/AleBarreto/Android-EX/blob/main/prints/navigation.png?raw=true)

 ![features](https://github.com/AleBarreto/Android-EX/blob/main/prints/features.png?raw=true)

## Network

Foi criado o modulo de network para prover toda a configuração do retrofit e seus interceptors:

```kotlin
// :network file: NetworkModule.kt
 @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY elseHttpLoggingInterceptor.Level.NONE}
        
    @Provides
    fun providesDefaultInterceptorQueryParameter() = DefaultQueryParameterInterceptor()
    
    @Provides
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,defaultInterceptorQueryParameter: DefaultQueryParameterInterceptor
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(defaultInterceptorQueryParameter)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL_TMDB)
        .client(okHttpClient)
        .build()
```

Cada modulo de feature deve forncener somente a interface do serviço e solicitar da injeção de dependencia o retrofit provido pelo modulo de network

```kotlin
// :featureA file: FeatureAService.kt
internal interface FeatureAService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("language") language: String = "pt-BR"): MovieResultResponse
}
```

```kotlin
// :featureA file: FeatureServiceAModule.kt
@Module
@InstallIn(ViewModelComponent::class)
internal object ServiceAModule {

    @Provides
    fun provideFeatureAService(retrofit: Retrofit): FeatureAService =
        retrofit.create(FeatureAService::class.java)
}
```
O codigo acima cria uma implementação dos endpoints da API definidos pela interface de serviço. Como usar a interface da api:

```kotlin
// :featureA file: RemoteMovieDataSource.kt
internal class RemoteMovieDataSource @Inject constructor(private val service: FeatureAService) {
    fun getPopularMovies(): Flow<MovieResultResponse> = flow {emit(service.getPopularMovies())}
}
```

![navigation](https://github.com/AleBarreto/Android-EX/blob/main/prints/network.png?raw=true)

## Camadas do modulo feature

Cada modulo feature segue o conceito do clean arch baseado na divisão de camadas, porém todo o projeto foi modularizado pensando em novas features e cada feature pode possuir camadas a mais baseado em sua necessidade.

- Data - responsavel por prover os conteudos e request da API.
- DI - responsavel pela injeção de dependencia do modulo.
- Domain - regras de negocios se houver.
- Navigation - prover navegação para dentro do modulo.
- Presentation - toda camada de view e viewModels.

![camadas](https://github.com/AleBarreto/Android-EX/blob/main/prints/camadas.png?raw=true)

## Commons

 O modulo commons deve ter a responsabilidade de conter tudo que for comun entre os modulos, exemplo: ExtensionFunctions e tambem injeçoes de depencias comum entre os modulos como os Dispatchers. 
 
 ![commons](https://github.com/AleBarreto/Android-EX/blob/main/prints/commons.png?raw=true)

## BuildSrc

TODO

## Arquivo secrets.properties.gpg

TODO

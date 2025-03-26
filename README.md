
# Automação Blog Agibank | Java - TestNG - Selenium ☕
___

## Instalação

### Windows x64
 - [Java SDK 21](https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe)
 - [Maven](https://maven.apache.org/install.html)
 - [Google Chrome - 134.0.6998.165](https://storage.googleapis.com/chrome-for-testing-public/134.0.6998.165/win64/chrome-win64.zip)

### MacOS x64
  - [Java SDK 21](https://download.oracle.com/java/21/latest/jdk-21_macos-x64_bin.dmg)
 - [Maven](https://maven.apache.org/install.html)
 - [Google Chrome - 134.0.6998.165](https://storage.googleapis.com/chrome-for-testing-public/134.0.6998.165/mac-x64/chrome-mac-x64.zip)


### Linux x64
  - [Java SDK 21](https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe)
 - [Maven](https://maven.apache.org/install.html)
 - [Google Chrome - 134.0.6998.165](https://storage.googleapis.com/chrome-for-testing-public/134.0.6998.165/linux64/chrome-linux64.zip)



## Execução

1. Após  baixar pasta do Google Chrome, insira o caminho do executável em "src/test/helpers/Configs.java - Linha 33":

```
    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //options.addArguments("--headless");
        options.setBinary("INSIRA_O_CAMINHO_AQUI");
    }
```

2. Acessar a pasta raiz do projeto e executar o seguinte comando:

```
mvn test
```

**OBS:** O pipeline está configurado, mas o Selenium não está localizando os elementos no modo "--headless".


# Cenarios

#### 1 - _sucessfullySearch_ (Busca com resultados)
  **Dado** que eu estou na Home <br />
  **E** que eu cliquei no botão de lupa no canto inferior direito <br />
  **E** que eu inseri um texto no campo <br />
  **Quando** eu enviar o texto <br />
**Então** a página será recarregada <br />
  **E** devera exibir apenas os artigos correspondentes a pesquisa

#### 2 - _searchWithNoResults_ (Busca sem resultados)
**Dado** que eu estou na Home <br />
  **E** que eu cliquei no botão de lupa no canto inferior direito <br />
  **Quando** eu enviar um texto invalido <br />
  **Então** irei visualizar a mensagem de ausencia de resultados

  #### 3 - _searchWithNoResults_ (Busca sem resultados)
**Dado** que eu estou na Home <br />
  **E** que eu cliquei no botao de lupa no canto inferior direito <br />
  **E** que eu enviei um texto invalido <br />
  **E** que eu visualizei a mensagem de ausência de resultados
  **E** que eu inseri novamente um texto valido no novo campo de busca
  **Quando** eu clicar no botão de lupa no novo campo
**Então** a página será recarregada <br />
  **E** deverá exibir apenas os artigos correspondentes á pesquisa


___

# BUGS

  #### 1 - _[FE] [WEB] [Home] NAO É POSSIVEL REALIZAR BUSCA AO RECARREGAR TELA_ (Busca sem resultados) - Criticidade: Alta
**Comportamento atual** <br /> 
Ao recarregar a tela da Home a partir do próprio browser (F5), ou clicando no logo do header, o evento de click do botão  de lupa perde a funcionalidade, sendo necessário abrir uma nova aba para conseguir realizar a busca novamente. <br />

**Comportamento esperado:** <br />
É esperado que seja possível realizar novamente a busca ao recarregar a página na Home<br />

  **OBS:** <br />
- Ao recarregar a tela estando em outras páginas do blog, isso não ocorre. <br />
- Validado em: Chrome - Edge - Brave

___

  #### 2 - _[FE] [MOBILE] [Home] BOTAO DO MENU NAO POSSUI FUNCIONALIDADE_ (Busca sem resultados) - Criticidade: Critico
**Comportamento atual** <br /> 
O menu "hamburguer" no canto inferior esquerdo não  possui funcionalidade, impossibilitando navegar entre os artigos ou realizar alguma busca na versão mobile<br />

**Comportamento esperado:** <br />
É esperado que seja atribuída alguma funcionalidade ao botão<br />

  **OBS:** <br />
- Validado em: iOS

___

  #### 3 - _[FE] [WEB] [Home] BOTAO DO MENU NAO POSSUI FUNCIONALIDADE_ (Busca sem resultados) - Criticidade: Muito baixa
**Comportamento atual** <br /> 
A mesma animação presente nas demais páginas antes de exibir completamente os artigos, não está sendo exibida na página de Stories ao carregar os artigos. <br />

**Comportamento esperado:** <br />
É esperado que a mesma animação esteja presente em todas as páginas <br />

  **OBS:** <br />
- Validado em: Chrome - Edge - Brave


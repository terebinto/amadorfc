package com.amadorfc.amadorfc.rest.service;

/**
 * Classe responsavel por manter URLs Rest
 */
public enum RestURL {

    GET_URL(""),
    LISTAR_USUARIOS("usuarios.php"),
    LISTAR_CAMPEONATOS("carregarLigas.php"),
    CARREGAR_EQUIPE_TID("equipe.php"),
    CARREGAR_CLASSIFICACAO("classificacao.php"),
    CARREGAR_PROXIMOS_JOGOS("proximosJogos.php"),
    LISTAR_BANNERS("banners.php"),
    LISTAR_ARTILHEIROS("artilharia.php"),
    LISTAR_NOTICIAS("noticias.php"),
    CARREGAR_JOGOS_REALIZADOS("ultimosJogos.php"),
    VER_JOGO("verJogo.php"),
    CARREGAR_CARTAO_AMARELO("cartoesAmarelos.php"),
    CARREGAR_CARTAO_VERMELHO("cartoesVermelhos.php"),
    CARREGAR_APOIO("apoio.php");

    private static final String uri = "http://www.amigosdabolaonline.com.br/servicos/%s";

    private String restUrl;

    RestURL(String restUrl) {
        this.restUrl = restUrl;
    }

    public String getUrl(String requestUrl) {
        return String.format(uri, requestUrl);
    }

    public String getUrl() {
        return String.format(uri, restUrl);
    }

}

package common.page;

public enum PageContext {
    WEB_VIEW("WEBVIEW"),
    NATIVE("NATIVE");

    public final String name;

    private PageContext(String name) {
        this.name = name;
    }
}

package constants;

public enum URL {
    ANDERSEN_MAIN_PAGE("https://qa-course-01.andersenlab.com/"),
    ANDERSEN_SELECT("https://qa-course-01.andersenlab.com/select");


    public String getUrl() {
        return url;
    }

    URL(String url) {
        this.url = url;
    }

    private String url;

}

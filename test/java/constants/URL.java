package constants;

public enum URL {
    ANDERSEN_MAIN_PAGE("https://qa-course-01.andersenlab.com/"),
    ANDERSEN_SELECT("https://qa-course-01.andersenlab.com/select"),
    ANDERSEN_DRAG_AND_DROP("https://qa-course-01.andersenlab.com/dragndrop"),
    ANDERSEN_ALERT("https://qa-course-01.andersenlab.com/actions"),
    REGISTION_PAGE("https://qa-course-01.andersenlab.com/registration");


    public String getUrl() {
        return url;
    }

    URL(String url) {
        this.url = url;
    }

    private String url;

}

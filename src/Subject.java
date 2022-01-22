public enum Subject {
    Math("математика"),
    English("английский"),
    Chemistry("химия"),
    Astronomy("астрономия");

    private String subject;

    Subject(String subject){
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}

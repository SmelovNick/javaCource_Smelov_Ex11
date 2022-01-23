public enum Subject {
    MATH("математика"),
    ENGLISH("английский"),
    CHEMISTRY("химия"),
    ASTRONOMY("астрономия"),
    LITERATURE("литература"),
    HISTORY("история");

    private String subject;

    Subject(String subject){
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public static Subject fromString(String text){
        for (Subject b : Subject.values()) {
            if (b.subject.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

}

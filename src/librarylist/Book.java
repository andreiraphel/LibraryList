package librarylist;

public class Book {
    /**
     * title field for Book object.
     */
    private String title;
    /**
     * author field for Book object.
     */
    private String author;
    /**
     * yearPublished field for Book object.
     */
    private int yearPublished;
    /**
     * isRented field for Book object.
     */
    private boolean isRented;

    /**
     * @param newTitle
     * @param newAuthor
     * @param newYearPublish
     */
    public Book(final String newTitle, final String newAuthor,
            final int newYearPublish) {
        this.title = newTitle;
        this.author = newAuthor;
        this.yearPublished = newYearPublish;
        this.isRented = false;
        /*
        System.out.println(
                this.title + " " + this.author + " " + this.yearPublished);
        */
    }

    /**
     * @return isRented
     */
    public boolean isRented() {
        return isRented;
    }

    /**
    *
    */
    public void rent() {
        this.isRented = true;
    }
    /**
    * @return this.title
    */
    public String getTitle() {
        return this.title;
    }
    /**
    * @return this.author
    */
    public String getAuthor() {
        return this.author;
    }
    /**
    * @return this.yearPublished
    */
    public int getYearPublished() {
        return this.yearPublished;
    }

}

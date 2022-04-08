package com.example.assignment2gc200455715.Models;

import com.example.assignment2gc200455715.Models.Images;

import java.util.Arrays;

public class Volume {
    //title
    private String title;
    //subtitle
    private String subtitle;
    //author
    private String[] authors;
    //categories
    private String[]categories;
    //published Date
    private String publishedDate;
    //page count
    private int pageCount;
    //about the book
    private String description;
    //image link
    Images imageLinks;

    public String[] getAuthors() {
        return authors;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String[] getCategories() {
        return categories;
    }

    public Images getImageLinks() {
        return imageLinks;
    }

    public String getName(){
        return title + " - " + subtitle;
    }

    //gives all the details of the book
    @Override
    public String toString() {
        if(publishedDate != null) {
            return String.format("%s(%s)", title, publishedDate.substring(0, 4));
        }
        return title;
    }
}

//"Volume{" +
//        "title='" + title + '\'' +
//        ", subtitle='" + subtitle + '\'' +
//        ", authors=" + Arrays.toString(authors) +
//        ", categories=" + Arrays.toString(categories) +
//        ", imageLinks=" + imageLinks +
//        '}';
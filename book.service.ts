import { Injectable } from '@angular/core';
import { Book } from './Book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  actualBooks : Book[] = [
    {bookId : 101, bookName:"C Programming",bookAuthor:"Denis Ritchie", bookPrice:850},
    {bookId : 102, bookName:"C++ Programming ",bookAuthor:"Stanle Lippman", bookPrice:950},
    {bookId : 103, bookName:"Java Programming",bookAuthor:"James Gosling", bookPrice:1250},
    {bookId : 104, bookName:"DotNet Programming",bookAuthor:"Prabhakar", bookPrice:1050},
    {bookId : 105, bookName:"Oracle Programming",bookAuthor:"Bill Pribyl", bookPrice:1350},
  ];
  constructor() { }
  getAllBooks() : Book[] { 
    console.log('BookService:getAllBooks()'); 
    return this.actualBooks; 
  }
  
  findABook(bookIdToFind: number) : Book {
    console.log('BookService:findABook()');
    let bookFound!: Book;
    for (let index = 0; index < this.actualBooks.length; index++) {
      const eachBookFromArray = this.actualBooks[index];
      if(eachBookFromArray.bookId == bookIdToFind) {
        bookFound = eachBookFromArray;  break;
      }
    }
    return bookFound;
  }
  addBook(newBook:Book) {    console.log('BookService:addBook()');    this.actualBooks.push(newBook);  }
  editExistingBook(bookToEdit: Book) : boolean {
    console.log('BookService:editExistingBook() ',bookToEdit);
    for (let index = 0; index < this.actualBooks.length; index++) {
      const eachBookFromArray = this.actualBooks[index];
      if(eachBookFromArray.bookId == bookToEdit.bookId) {
        console.log('BookService:editExistingBook() FOUND ',bookToEdit);
        this.actualBooks.splice(this.actualBooks.indexOf(eachBookFromArray),1); //remove that book as per the first occurance;
        this.actualBooks.push(bookToEdit);// and add this new one which is passed as an argument;
        console.log('BookService:editExistingBook() ADDED AS ',bookToEdit);
        return true;
      }
    }
    return false;
  }
  deleteABook(bookIdToDelete: number) {
    console.log('BookService:deleteABook()'+bookIdToDelete);
    for (let index = 0; index < this.actualBooks.length; index++) {
      const eachBookFromArray = this.actualBooks[index];
      if(eachBookFromArray.bookId == bookIdToDelete) {
        this.actualBooks.splice(this.actualBooks.indexOf(eachBookFromArray),1); //remove that book as per the first occurance;
        return true;
      }
    }
    return false;
  }
}

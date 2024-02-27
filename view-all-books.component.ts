import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Book } from '../Book';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-all-books',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './view-all-books.component.html',
  styleUrl: './view-all-books.component.css'
})
export class ViewAllBooksComponent implements OnInit { //UI 

  newBook: Book = new Book();
  allBooks! : Book[]; //local empty array 
  constructor(private bookService: BookService) {} //get the service
  ngOnInit(): void {
    this.allBooks = this.bookService.getAllBooks(); //invoke service
  }
  deleteIt(id: number) {
    this.bookService.deleteABook(id);
  }
  editIt(book: Book) {
    console.log('current value before editing ',book);
    this.bookService.editExistingBook(book);
  }

 // book = new Book();
  addIt() {
    console.log('adding it ');
    let book: Book;
    book = new Book();
    book.bookId = this.newBook.bookId;
    book.bookName = this.newBook.bookName;
    book.bookAuthor = this.newBook.bookAuthor;
    book.bookPrice = this.newBook.bookPrice;
    this.bookService.addBook(book);
  }

}

package com.greedy.level02.normal.book.run;

import com.greedy.level02.normal.book.model.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        BookDTO bookDTO= new BookDTO();
        bookDTO.printlnInformation();
        BookDTO bookDTO3= new BookDTO("자바의 정석","도우 출판","남궁성");
        bookDTO3.printlnInformation();
        BookDTO bookDTOALL= new BookDTO("홍길동전", "활빈당", "허균", 5000000, 0.5);
        bookDTOALL.printlnInformation();
    }
}

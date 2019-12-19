package com.example.dbtermprojectspringboot.service;


import com.example.dbtermprojectspringboot.domain.*;
import com.example.dbtermprojectspringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BorrowService { // 예외처리 및 데이터 가공 등등을 해야함
    @Autowired
    private BookRepository bookRepository;

    // 대출 기록 추가

    /**
     * @param borrow : borrow.isbn, borrow.title, borrow.customerId
     * @return : 성공시 1, book 테이블의 is_borrow를 1로 갱신. 실패 시 0
     */
//    public int insertBorrow(Borrow borrow) {
//        try {
//            return this.bookRepository.insert(borrow);
//        } catch (Exception e) {
//            return 0;
//        }
//    }

    //도서 반납 요청(borrow.isReturn을 1로 변경)

    /**
     * @param borrowNumber : borrow.customerId
     * @return : 성공시 1, 실패 시 0
     */
//    public int requestReturn(int borrowNumber) {
//        try {
//            return this.bookRepository.setReturnTrue(borrowNumber);
//        } catch (Exception e) {
//            return 0;
//        }
//    }

    // 일정 기간 동안 대출을 많이한 Top 10 회원 검색

    /**
     * @param start : Date (yyyy-mm-dd)
     * @param end   : Date (yyyy-mm-dd)
     * @return : start~end 사이에 대출을 가장 많이 한 Top 10 Customer List
     * - 인덱스 순서가 곧 순위
     * - 마지막 값이 해당 회원의 대출 수
     */
//    public List<Map<String, Object>> getTop10CustomerByPeriod(Date start, Date end) {
//        try {
//            return bookRepository.getTop10CustomerByPeriod(start, end);
//        } catch (Exception e) {
//            return new ArrayList<>();
//        }
//    }

    //회원의 대출 현황 조회

    /**
     * @param customerId : 회원 id
     * @return : 회원의 대출 현황 List
     */
//    public List<Borrow> getAllBorrowsById(String customerId) {
//        try {
//            return bookRepository.getAllBorrowsById(customerId);
//        } catch (Exception e) {
//            return new ArrayList<>();
//        }
//    }

    // 반납된 대출 기록 삭제

    /**
     * @return : 삭제된 대출 기록 수
     */
//    public int deleteReturnedBorrows() {
//        try {
//            return bookRepository.deleteReturnedBorrows();
//        } catch (Exception e) {
//            return 0;
//        }
//    }


    // 반납 승인 대기 목록 조회(Borrows)

    /**
     * @return : 반납 승인 대기중인 Borrows 리스트
     */
//    public List<Borrow> getBorrowsThatAwaitingApprovalForReturn() {
//        try {
//            return bookRepository.getBorrowsThatAwaitingApprovalForReturn();
//        } catch (Exception e) {
//            return new ArrayList<>();
//        }
//    }
}

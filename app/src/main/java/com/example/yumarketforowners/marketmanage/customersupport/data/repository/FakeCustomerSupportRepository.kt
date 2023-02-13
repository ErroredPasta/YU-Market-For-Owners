package com.example.yumarketforowners.marketmanage.customersupport.data.repository

import com.example.yumarketforowners.marketmanage.customersupport.data.mapper.toCustomerSupport
import com.example.yumarketforowners.marketmanage.customersupport.data.dto.FaqDto
import com.example.yumarketforowners.marketmanage.customersupport.domain.model.FaqCategory
import com.example.yumarketforowners.marketmanage.customersupport.domain.model.Faq
import com.example.yumarketforowners.marketmanage.customersupport.domain.repository.CustomerSupportRepository
import javax.inject.Inject


class FakeCustomerSupportRepository @Inject constructor() : CustomerSupportRepository {

    override fun getFaqByCategory(faqCategory: FaqCategory): List<Faq> {
        return when (faqCategory) {
            FaqCategory.LOGIN -> listOf(
                FaqDto(
                    id = 0,
                    csInfoId = 0,
                    csTitle = "   로그인 오류시 이용방법                                                ",
                    faqCategory = FaqCategory.LOGIN,
                    csAuthor = "위드마켓",
                    csContentTitle = "이 글은 로그인 오류시 이용방법 입니다",
                    csContentBody = "로그인 오류시 앱을 재부팅하여 사용하고" +
                            "그래도 로그인이 되지않는다면 고객센터로 연락바랍니다."
                )
            )

            FaqCategory.USE -> listOf(
                FaqDto(
                    id = 1,
                    csInfoId = 1,
                    csTitle = "   애플리케이션 이용방법                                        ",
                    faqCategory = FaqCategory.USE,
                    csAuthor = "위드마켓",
                    csContentTitle = "이 글은 애플리케이션 이용방법 입니다",
                    csContentBody = "위드마켓은 사용자 주변의 있는 다양한 스토어의 정보들을 제공하고" +
                            "사용자에게 맞춤형 서비스를 제공해드립니다."
                )

            )

            FaqCategory.ORDER -> listOf(
                FaqDto(
                    id = 2,
                    csInfoId = 2,
                    csTitle = "   주문오류시 이용방법                                        ",
                    faqCategory = FaqCategory.ORDER,
                    csAuthor = "위드마켓",
                    csContentTitle = "이 글은 주문오류시 이용방법 입니다",
                    csContentBody = "주문 오류로 인해 결제는 되었지만 알람 PUSH가 오지않는 경우는"
                            + "고객센터에 연락해 주시고" + "<br>" + "결제 동작이 정상적이지 않았다면 재주문 부탁드립니다."

                )
            )

            FaqCategory.REVIEW -> listOf(
                FaqDto(
                    id = 3,
                    csInfoId = 3,
                    csTitle = "   리뷰오류시 이용방법                                        ",
                    faqCategory = FaqCategory.REVIEW,
                    csAuthor = "위드마켓",
                    csContentTitle = "이 글은 리뷰오류시 이용방법 입니다",
                    csContentBody = "리뷰의 수정버튼을 통해 다시 재리뷰를 부탁드립니다."
                )
            )


            FaqCategory.ETC -> listOf(
                FaqDto(
                    id = 4,
                    csInfoId = 4,
                    csTitle = "   기타 오류시 이용방법                                        ",
                    faqCategory = FaqCategory.ETC,
                    csAuthor = "위드마켓",
                    csContentTitle = "이 글은 기타오류시 이용방법 입니다",
                    csContentBody = "이러한 오류는 없으셨나요?"
                            + "이러한 오류는 없으셨나요?"

                )
            )
        }.map { it.toCustomerSupport() }
    }
}
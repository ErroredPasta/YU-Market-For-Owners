package com.example.yumarketforowners.core.presentation.viewholder

import androidx.annotation.LayoutRes
import com.example.yumarketforowners.R
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.viewholder.MyChatViewHolder
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.viewholder.OpponentChatViewHolder
import com.example.yumarketforowners.marketmanage.customersupport.presentation.viewholder.CustomerSupportViewHolder
import com.example.yumarketforowners.marketmanage.market.presentation.viewholder.DeliveryFeeViewHolder
import com.example.yumarketforowners.itemmanage.presentation.viewholder.ItemViewHolder
import com.example.yumarketforowners.itemmanage.presentation.viewholder.OptionGroupViewHolder
import com.example.yumarketforowners.itemmanage.presentation.viewholder.OptionViewHolder
import com.example.yumarketforowners.marketmanage.notice.presentation.viewholder.NoticeViewHolder
import com.example.yumarketforowners.orderlist.presentation.viewholder.OrderItemViewHolder
import com.example.yumarketforowners.orderlist.presentation.viewholder.OrderViewHolder
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.viewholder.ChatRoomViewHolder
import com.example.yumarketforowners.reviewmanage.review.presentation.viewholder.ReviewViewHolder
import kotlin.reflect.KClass

enum class CellType(
    val clazz: KClass<*>,
    @LayoutRes val layoutId: Int
) {
    ITEM_CELL(ItemViewHolder::class, R.layout.view_holder_item),
    REVIEW_CELL(ReviewViewHolder::class, R.layout.view_holder_review),
    CHAT_ROOM_CELL(ChatRoomViewHolder::class, R.layout.view_holder_chat_room),
    ORDER_CELL(OrderViewHolder::class, R.layout.view_holder_order),
    ORDER_ITEM_CELL(OrderItemViewHolder::class, R.layout.view_holder_order_item),
    OPTION_GROUP_CELL(OptionGroupViewHolder::class, R.layout.view_holder_option_group),
    OPTION_CELL(OptionViewHolder::class, R.layout.view_holder_option),
    NOTICE_CELL(NoticeViewHolder::class, R.layout.view_holder_notice),
    OPPONENT_CHAT_CELL(OpponentChatViewHolder::class, R.layout.view_holder_opponent_chat),
    MY_CHAT_CELL(MyChatViewHolder::class, R.layout.view_holder_my_chat),
    DELIVERY_FEE_CELL(DeliveryFeeViewHolder::class, R.layout.view_holder_delivery_fee),
    CUSTOMER_SERVICE_CELL(CustomerSupportViewHolder::class, R.layout.view_holder_faq),
}

package com.hopecoding.retrofitkotlin.model


data class CryptoModel(
    val asset_id: String,
    val name: String,
    val type_is_crypto: String,
    val data_quote_start: String,
    val data_quote_end: String,
    val data_orderbook_start: String,
    val data_orderbook_end: String,
    val data_trade_start: String,
    val data_trade_end: String,
    val data_symbols_count: String,
    val volume_1hrs_usd: String,
    val volume_1day_usd: String,
    val volume_1mth_usd: String,
    val price_usd: String,
    val id_icon: String,
    val data_start: String,
    val data_end: String,
) {

}
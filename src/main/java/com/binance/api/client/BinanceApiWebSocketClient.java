package com.binance.api.client;

import java.io.Closeable;
import java.util.List;

import com.binance.api.client.domain.event.AggTradeEvent;
import com.binance.api.client.domain.event.AllMarketTickersEvent;
import com.binance.api.client.domain.event.CandlestickEvent;
import com.binance.api.client.domain.event.DepthEvent;
import com.binance.api.client.domain.event.TradeEvent;
import com.binance.api.client.domain.event.UserDataUpdateEvent;
import com.binance.api.client.domain.market.CandlestickInterval;

/**
 * Binance API data streaming facade, supporting streaming of events through web sockets.
 */
public interface BinanceApiWebSocketClient extends Closeable {

    /**
     * Open a new web socket to receive {@link DepthEvent depthEvents} on a callback.
     *
     * @param symbols   market (one or coma-separated) symbol(s) to subscribe to
     * @param callback  the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onDepthEvent(String symbols, BinanceApiCallback<DepthEvent> callback);

    /**
     * Open a new web socket to receive {@link CandlestickEvent candlestickEvents} on a callback.
     *
     * @param symbols   market (one or coma-separated) symbol(s) to subscribe to
     * @param interval  the interval of the candles tick events required
     * @param callback  the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onCandlestickEvent(String symbols, CandlestickInterval interval, BinanceApiCallback<CandlestickEvent> callback);

    /**
     * Open a new web socket to receive {@link AggTradeEvent aggTradeEvents} on a callback.
     *
     * @param symbols   market (one or coma-separated) symbol(s) to subscribe to
     * @param callback  the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onAggTradeEvent(String symbols, BinanceApiCallback<AggTradeEvent> callback);

    /**
     * Open a new web socket to receive {@link TradeEvent tradeEvents} on a callback.
     *
     * @param symbols   market (one or coma-separated) symbol(s) to subscribe to
     * @param callback  the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onTradeEvent(String symbols, BinanceApiCallback<TradeEvent> callback);

    /**
     * Open a new web socket to receive {@link UserDataUpdateEvent userDataUpdateEvents} on a callback.
     *
     * @param listenKey the listen key to subscribe to.
     * @param callback  the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onUserDataUpdateEvent(String listenKey, BinanceApiCallback<UserDataUpdateEvent> callback);

    /**
     * Open a new web socket to receive {@link AllMarketTickersEvent allMarketTickersEvents} on a callback.
     *
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onAllMarketTickersEvent(BinanceApiCallback<List<AllMarketTickersEvent>> callback);

    /**
     * @deprecated This method is no longer functional. Please use the returned {@link Closeable} from any of the other methods to close the web socket.
     */
    @Override
    @Deprecated
    void close();
}

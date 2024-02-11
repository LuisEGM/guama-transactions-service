package com.guama.transactions.context.shared;

import com.cloudogu.cb.CommandHandler;

/**
 * View handler interface
 *
 * @param <R> Class to be returned
 * @param <C> A view class
 */
public interface IViewHandler<R, C extends IView<R>> extends CommandHandler<R, C> {
}

package com.algaworks.financeiro.util;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Inject EntityManager manager;

	public Object invoke(InvocationContext context) throws Exception {

		EntityTransaction trx = manager.getTransaction();
		boolean criador = false;

		try {

			if (!trx.isActive()) {
				/**
				 * TRUQUE PARA FAZER ROLLBACK NO QUE JÁ PASSOU(SENÃO, UM FUTURO
				 * COMMIT, CONFIRMARIA ATÉ MESMO OPERAÇÕES SEM TRANSAÇÃO)
				 **/
				trx.begin();
				trx.rollback();

				trx.begin();

				criador = true;
			}
			return context.proceed();
		} catch (Exception e) {
			if (trx != null && criador) {
				trx.rollback();
			}
			throw e;
		} finally {
			if (trx != null && trx.isActive() && criador) {
				trx.commit();
			}
		}

	}

}

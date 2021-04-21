package br.com.uol.pagseguro.example;

import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Transaction;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.service.NotificationService;

public class ReceiveNotifications {

    public static void main(String[] args) {

    	// Substitute the code below with a notification code for your transaction. 
        // You receive this notification code through a post on the URL that you specify in 
        // this page: 
    	/** @link https://pagseguro.uol.com.br/integracao/notificacao-de-transacoes.jhtml*/
        String notificationCode = "512AF8-49E2FBE2FB71-799426FFAC58-90F5C1";

        Transaction transaction = null;
        try {
            // Check transaction
            transaction = NotificationService.checkTransaction(new AccountCredentials("renowe@tg7.com.br",
                    "C185FF46ED014E9BB653213FBA5A4443"), notificationCode);
        } catch (PagSeguroServiceException e) {
            System.err.println(e.toString());
        }

        if (transaction != null) {
            System.out.println("transaction code: " + transaction.getCode());
            System.out.println("transaction status: " + transaction.getStatus());
        }
    }
}

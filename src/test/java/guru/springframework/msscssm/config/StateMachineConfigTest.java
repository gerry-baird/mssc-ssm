package guru.springframework.msscssm.config;

import guru.springframework.msscssm.domain.Payment;
import guru.springframework.msscssm.domain.PaymentEvent;
import guru.springframework.msscssm.domain.PaymentState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StateMachineConfigTest {

    @Autowired
    StateMachineFactory<PaymentState, PaymentEvent> factory;

    @Test
    void testNewStateMachine(){
        StateMachine <PaymentState, PaymentEvent> sm = factory.getStateMachine();

        sm.start();
        System.out.println("At start: " + sm.getState());

        sm.sendEvent(PaymentEvent.PRE_AUTHORIZE);
        System.out.println("At Pre Authorise: " + sm.getState());

        sm.sendEvent(PaymentEvent.PRE_AUTH_APPROVED);
        System.out.println("After Pre Auth Approved : " + sm.getState());
    }


}
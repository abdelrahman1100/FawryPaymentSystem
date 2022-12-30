package User;

import Providers.ServiceProvider;
import Services.Service;

public interface Subject {
    void subscirbe (Client observer, ServiceProvider s);
    void unsubscirbe (Client observer);
    void notify (Client observer);
}
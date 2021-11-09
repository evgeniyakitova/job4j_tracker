package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса
 * @author EVGENIYA KITOVA
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей в системе и принадлежащих им банковских
     * счетов осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и, если его еще нет в системе, добавляет его.
     * Для хранения банковских счетов пользователя создается пустой список типа ArrayList.
     * @param user модель пользователя, которая добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый банковский счёт пользователя в список его счетов.
     * @param passport номер паспорта пользователя
     * @param account банковский счет, добавляемый в список счетов пользователя
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }

    }

    /**
     * Метод находит пользователя по его номеру паспорта
     * @param passport номер паспорта пользователя
     * @return возвращает найденного пользователя или null,
     * если пользователя с таким номером паспорта нет в системе
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst();
    }

    /**
     * Метод находит один из банковских счетов пользователя
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты искомого банковского счёта
     * @return возвращает найденный банковский счёт или null,
     * если пользователя с таким номером паспорта нет в системе,
     * либо у пользователя нет счетов с такими реквизитами
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод выполняет перевод денег с одного счёта на другой.
     * @param srcPassport номер паспорта пользователя, со счёта которого выполняется перевод средств
     * @param srcRequisite реквизиты счёта, с которого выполнется перевод средств
     * @param destPassport номер паспорта пользователя, на счёт которого выполняется перевод средств
     * @param destRequisite реквизиты счёта, на который выполнется перевод средств
     * @param amount сумма перевода
     * @return возвращает true, если перевод выполнен успешно, или false,
     * если один из банковских счетов не найден,
     * либо на одном счету не хватает средств для выполнения перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            if (srcAccount.get().getBalance() >= amount) {
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}

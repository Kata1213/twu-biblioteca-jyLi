package com.twu.biblioteca;

class MenuItem {
    private String title;
    private Runnable func;

            MenuItem(String title, Runnable func) {
                this.title = title;
                this.func = func;
            }

            void run() {
                func.run();
            }

            Runnable getFunc() {
                return func;
            }

            String getTitle() {
                return title;
            }
}

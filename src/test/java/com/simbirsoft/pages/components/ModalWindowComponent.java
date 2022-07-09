package com.simbirsoft.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ModalWindowComponent {

    public SelenideElement modalContentWindow = $("div.modal-content"),
            modalWindowHeader = $("div#example-modal-sizes-title-lg"),
            table = $("div.table-responsive"),
            closeModalButton = $("button#closeLargeModal");
}
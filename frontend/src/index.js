import {renderMessage} from "./components/god-message/god-message";

async function mainPage() {
    await renderMessage();
}

window.onload = mainPage;
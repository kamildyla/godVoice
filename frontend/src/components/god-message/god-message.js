import {loadMessage} from "../../service/api-service";
import {mapToMessage} from "../../mapper/message-mapper";
import './god-message.scss';

export async function renderMessage() {
    const messageFromDb = await loadMessage();
    const message = mapToMessage(messageFromDb);

    const hello = document.getElementById('main');

    const preparedMessage = document.createElement('div');
    preparedMessage.id = 'message';
    preparedMessage.innerHTML += `
        <h1>${message.volumeShort}, ${message.chapterNumber}, ${message.verses}</h1>
    `;

    hello.appendChild(preparedMessage);
}

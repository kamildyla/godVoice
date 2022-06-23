import {loadMessage} from "../../service/api-service";

export async function renderMessage() {
    const messageFromDb = await loadMessage();
    const hello = document.getElementById('hello');

    const message = document.createElement('div');
    message.innerHTML += `
        <div id="singleMssage">
            <h1>${messageFromDb.volumeShort}, ${messageFromDb.chapterNumber}, ${messageFromDb.verses}</h1>
        </div>
    `;

    hello.appendChild(message);
}

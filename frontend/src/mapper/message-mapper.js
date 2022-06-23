import {Message} from "../model/message";

export function mapToMessage(messageFromDb) {
    const message = new Message();
    message.volumeShort = messageFromDb.volumeShort;
    message.chapterNumber = messageFromDb.chapterNumber;
    message.verses = messageFromDb.verses;
    return message;
}
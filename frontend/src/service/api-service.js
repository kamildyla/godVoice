export async function loadMessage() {
    const item = await fetch('http://localhost:8095');
    return await item.json();
}
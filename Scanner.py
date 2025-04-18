import cv2
from pyzbar import pyzbar
import datetime

def decode(frame):
    # Detect and decode barcodes/QR codes in the frame
    decoded_objects = pyzbar.decode(frame)
    for obj in decoded_objects:
        # Draw a rectangle around the code
        points = obj.polygon
        if len(points) > 4:  # fix in case of non-quadrilateral
            hull = cv2.convexHull(np.array([point for point in points], dtype=np.float32))
            hull = list(map(tuple, np.squeeze(hull)))
        else:
            hull = points
        
        n = len(hull)
        for j in range(0, n):
            cv2.line(frame, hull[j], hull[(j + 1) % n], (255, 0, 0), 2)

        # Extract and display data
        data = obj.data.decode("utf-8")
        cv2.putText(frame, data, (obj.rect.left, obj.rect.top - 10), 
                    cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0, 255, 0), 2)
        print(f"Scanned Data: {data}")
    return frame

def scanner():
    cap = cv2.VideoCapture(0)

    if not cap.isOpened():
        print("Cannot open camera")
        return

    print("Press 'q' to quit.")

    while True:
        ret, frame = cap.read()
        if not ret:
            break

        frame = decode(frame)
        cv2.imshow("QR/Barcode Scanner", frame)

        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    cap.release()
    cv2.destroyAllWindows()

if __name__ == "__main__":
    scanner()
